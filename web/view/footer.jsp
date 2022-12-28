<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.time.*" %>

<footer>

    <p>
        <%
            InputStream stream = getServletContext().getResourceAsStream("db.properties");
            Properties props = new Properties();
            props.load(stream);
            out.print("STREAM = " + props.getProperty("dburl"));
        %>
    </p>

    <% out.print(getServletContext().getInitParameter("email")); %>
</footer>

</body>
</html>