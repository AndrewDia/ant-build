<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 0;
        }

        nav {
            position: fixed;
            top: 0;
            left: 0;
            width: 25%;
            height: 100%;
            background: #4f606c;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin-top: 4em;
        }

        li {
            margin: 1.3em 0;
        }

        li:first-child {
            margin-top: 0;
        }

        a {
            text-decoration: none;
        }

        li a {
            font-size: 1.35em;
            text-transform: uppercase;
            color: white;
            font-weight: bold;
        }

        li a:hover {
            color: #98aab4;
        }

        main {
            margin-left: 25%;
            padding: 4em 3em;
        }

        h1 {
            margin: 0;
        }
    </style>
</head>
<body>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li>&nbsp;</li>
        <li><a href="${pageContext.request.contextPath}/list/products">List of products</a></li>
        <li><a href="${pageContext.request.contextPath}/list/orders">List of orders</a></li>
        <li>&nbsp;</li>
        <li><a href="${pageContext.request.contextPath}/create/product">Create product</a></li>
        <li><a href="${pageContext.request.contextPath}/create/order">Create order</a></li>
    </ul>
</nav>
<main>
    <h1>Hello, User</h1>
    <p>This application allows you to keep records of products and display them in convenient format.
        Another function of this app is order creation based on the given products. </p>
</main>
</body>
</html>