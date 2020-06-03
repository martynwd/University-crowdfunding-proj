package com.example.crowdfunding.controller;

import com.example.crowdfunding.domain.Fund;
import com.example.crowdfunding.domain.Transaction;
import com.example.crowdfunding.domain.User;
import com.example.crowdfunding.repos.FundRepo;
import com.example.crowdfunding.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private FundRepo projectRepo;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    public String greeting( Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Fund> projects = projectRepo.findAll();
        model.put("projects",projects);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam Long goal,
            @RequestParam Long current_balance,
           Map <String, Object> model){

         Fund project = new Fund(title,text,user,goal,current_balance );

         projectRepo.save(project);

        Iterable<Fund> projects = projectRepo.findAll();
        model.put("projects",projects);
        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Fund> projects;
        if (filter!= null && filter.isEmpty()) {
            projects = projectRepo.findByTag(filter);
        } else {
            projects = projectRepo.findAll();
        }
        model.put("projects",projects);
        return "main";
    }
    @GetMapping("/user-messages/{user}")
    public String userMessages(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,

            Model model
            ){
        Set<Fund> funds =  user.getFunds();
        model.addAttribute("projects",funds);

        model.addAttribute("isCurrentUser",currentUser.equals(user));

        return "userMessages";
    }
    @PostMapping("/user-messages/{user}")
    public String updateMessage(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            @RequestParam("id") Fund fund,
            @RequestParam("text") String text,
            @RequestParam("goal") Long goal

    ){
        fund.setText(text);
        fund.setGoal(goal);
        projectRepo.save(fund);
        return "redirect:/user-messages/" + user.getId();
    }
    @GetMapping("/donate")
    public String donate(@AuthenticationPrincipal User user,
                         Map<String, Object> model

    )
    {
        Iterable<Fund> projects;

        projects = projectRepo.findAll();
        model.put("projects",projects);
        return "donate";
    }
    @PostMapping("/donate")
    public String processTransaction(
            @AuthenticationPrincipal User user,
            @RequestParam Long fundId,
            @RequestParam Long amount,
            Map <String, Object> model
    ){
        Iterable<Fund> projects;
        if(!transactionService.processTransaction(user.getId(),fundId,amount)){
            model.put("message","Not enough money");
        }


        projects = projectRepo.findAll();
        model.put("projects",projects);
        return "donate";
    }


}