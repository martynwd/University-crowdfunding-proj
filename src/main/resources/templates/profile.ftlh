<#import "parts/common.ftlh" as content >

<@content.page>
    <h5>${username}</h5>
    <h5>Balance:  ${balance}</h5>
    <form  method="post">


        <div><label> Password: <input type="password" name="password" class="form-control"/> </label></div>
        <div><label> Add balance: <input type="number" name="balance" class="form-control"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="Save"/></div>
    </form>
</@content.page>