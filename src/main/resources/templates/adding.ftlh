<#import "parts/login.ftlh" as login >
<#import "parts/common.ftlh" as content >
<@content.page>

    <div>
        <@login.logout />
        <span>
            <a href="/user">User list</a>
        </span>
    </div>


    <div>
        <form method="post">
            <input type="text" name="title" placeholder="Enter project name">
            <input type="text" name="text" placeholder="Text">
            <input type="number" name="goal" placeholder="Text">
            <input type="number" name="current_balance" placeholder="Text">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="text" name="tag" placeholder="Enter tag">
            <button type="submit">Add</button>
        </form>
    </div>
    <div>Featured Projects</div>
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