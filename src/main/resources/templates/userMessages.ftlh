<#import "parts/common.ftlh" as content >

<@content.page>
    <#if isCurrentUser>
        <div>
            <form method="post">
                <input type="text" name="title" placeholder="Enter project name" class="form-control mainpage__adding_form">
                <input type="text" name="text" placeholder="Text" class="form-control mainpage__adding_form">
                <input type="number" name="goal" placeholder="Goal" class="form-control mainpage__adding_form">
                <input type="number" name="current_balance" placeholder="Start balance" class="form-control mainpage__adding_form">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="id" value="<#if fund??>${fund.id}</#if>"  />

                <button type="submit" class="btn btn-primary butn">Save</button>
            </form>
        </div>
    </#if>

<#include "parts/projectList.ftlh">
</@content.page>