<%@ page import="jakarta.servlet.http.Cookie" %>

<%
    String username = "Unknown Admin";

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
<title>Admin Dashboard</title>
</head>

<body>

<h1>Welcome Admin</h1>

<p>
<strong>Active Admin Session:</strong>
<%= username %>
</p>

<a href="index.html">Back to Login</a>

</body>
</html>