<#import "parts/login.ftlh" as login >
<#import "parts/common.ftlh" as c >
<@c.page>
    Login page
    <@login.login "/login" />
    <a href="/registration">Add new User</a>
</@c.page>

