<#import "macro/base.ftl" as base>

<@base.page>
    <h1>Registration</h1>
    <form action="/registration" method="post">
        <div>
            <label> User Name:
                <input type="text" name="username"/>
            </label>
        </div>
        <div>
            <label> Password:
                <input type="password" name="password"/>
            </label>
        </div>
        <div>
            <label> First Name:
                <input type="text" name="firstName"/>
            </label>
        </div>
        <div>
            <label> Last Name:
                <input type="text" name="lastName"/>
            </label>
        </div>
        <div>
            <label> IsikuKood:
                <input type="number" name="isikuKood"/>
            </label>
        </div>
        <div>
            <label> Email:
                <input type="email" name="email"/>
            </label>
        </div>
        <input type="submit" value="Registration"/>
        </div>
    </form>
</@base.page>