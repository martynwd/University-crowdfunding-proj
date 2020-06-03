<#import "parts/common.ftlh" as content>

<@content.page>
   List of Users

    <table>
        <thead>
            <tr>Name</tr>
            <tr>Role</tr>
            <th></th>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>
                        ${role}<#sep>
                    </#list>
                </td>
                <td>
                    ${user.balance?ifExists}
                </td>
                <td>
                    <a href="/user/${user.id}">edit</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@content.page>