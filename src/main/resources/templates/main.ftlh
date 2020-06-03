<#import "parts/login.ftlh" as login >
<#import "parts/common.ftlh" as content >
<@content.page>
    <div class="mainpage row">



        <div class="mainpage_adding col-sm-8">
            <form method="post">
                <input type="text" name="title" placeholder="Enter project name" class="form-control mainpage__adding_form">
                <input type="text" name="text" placeholder="Text" class="form-control mainpage__adding_form">
                <input type="number" name="goal" placeholder="Goal" class="form-control mainpage__adding_form">
                <input type="number" name="current_balance" placeholder="Start balance" class="form-control mainpage__adding_form">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />

                <button type="submit" class="btn btn-primary butn">Add</button>
            </form>
            <div class="mainpage__search">
                <form method="post" action="filter">
                    <input type="text" name="filter" value="${filter?ifExists}" class="form-control mainpage__adding_form">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-primary butn">Find</button>
                </form>
            </div>
        </div>
        <div class="mainpage__singout_btn col-sm-3">
            <@login.logout />

        </div>



    </div>

<#include "parts/projectList.ftlh">

</@content.page>