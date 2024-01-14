<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>
<body>
<form role="cardnumber" method="post" >
    <table style="with: 50%">

        <tr>
            <td>Number of your card: ${cardNumber}</td>
        </tr>

        <tr>
            <td>Number of your account: ${accountNumber}</td>
        </tr>

    </table>
    <a class="nav-link active" aria-current="page" href="/web/general"> To Main </a>
</form>
<%@include file="footer.jsp"%>
