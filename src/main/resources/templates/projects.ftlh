<#import "parts/common.ftlh" as content >
<@content.page>
    <h3>Featured projects now</h3>
    <div>
        <form method="post" action="filter">
            <input type="text" name="filter" value="${filter?ifExists}">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Find</button>
        </form>
    </div>
    <#list projects as project>
        <div>
            <b>${project.id}</b>
            <span>${project.authorName}</span>
            <h3>${project.title}</h3>
            <span>${project.text}</span>
            <span>${project.goal}</span>
            <span>${project.current_balance}</span>

        </div>
    <#else>
        No projects now
    </#list>

</@content.page>