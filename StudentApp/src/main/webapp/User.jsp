<%@ page import="jakarta.servlet.http.Cookie" %>

<%
    String username = "Not Found";

    Cookie[] cookies = request.getCookies();

    if(cookies != null)
    {
        for(Cookie c : cookies)
        {
            if(c.getName().equals("savedUsername"))
            {
                username = c.getValue();
                break;
            }
        }
    }
%>


<!DOCTYPE html>
<html>

<head>
<title>User Dashboard</title>
</head>

<body>

<h1>Welcome User</h1>

<p>
<strong>Active User Session:</strong>
<%= username %>
</p>

<a href="index.html">Back to Login</a>

</body>

</html>