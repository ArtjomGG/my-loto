<#import "macro/base.ftl" as base>

<@base.page>
    <h1>Login</h1>
    <form action="/login" method="post">
        <div class="form-group">
            <label for="usernameid">User Name:</label>
            <input type="text" name="username" class="form-control" id="usernameid" aria-describedby="usernamesmallid">
            <small id="usernamesmallid" class="form-text text-muted">Input User Name Here!</small>
        </div>

        <div>
            <label> Password:
                <input type="password" name="password"/>
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</@base.page>