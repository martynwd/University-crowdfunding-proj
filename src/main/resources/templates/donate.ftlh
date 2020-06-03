<#import "parts/common.ftlh" as content >

<@content.page>
    <h2>Which project you want to support</h2>
    <div class="error_message">
        <h3>${message?ifExists}</h3>
    </div>
    <div class="project_list">

        <#list projects as project>
            <div class="project_list__element_donate">



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
                    <div>
                        <h5>donate</h5>
                        <form method="post" action="donate">
                            <div class="form-inline">
                                <div class="form-group mx-sm-3 mb-2">
                                    <label for="inputAmount"></label>
                                    <input type="number" class="form-control" id="inputAmount" placeholder="Enter sum..." name="amount">
                                </div>
                                <input type="hidden" name="fundId" value="${project.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-primary">Donate</button>
                            </div>

                        </form>
                    </div>
                </#if>





            </div>
        <#else>
            No projects now
        </#list>
    </div>
</@content.page>


