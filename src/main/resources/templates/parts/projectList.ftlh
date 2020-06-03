<#include "./security.ftlh">
<div class="project_list">
<#list projects as project>
    <div class="project_list__element">


        <a href="/user-messages/${project.author.id}" class="main__link">${project.authorName}</a>


        <h4>${project.title}</h4>
        <h5>${project.text}</h5>
        <#if project.current_balance gte project.goal>
           <span>Completed we collect:</span>
            <span>${project.goal}</span>
            <#else>
                <div>
                    <span>Collected: </span>
                    <span>${project.current_balance}</span>
                </div>
                <div>
                    <span>From </span>
                    <span>${project.goal}</span>
                </div>

        </#if>





    </div>
<#else>
    No projects now
</#list>
</div>