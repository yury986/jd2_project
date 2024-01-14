<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>
<body>
<form role="card" method="post" action="/web/card" >
    <table style="with: 50%">

        <h1>Choose card: Visa, Visa Gold, Visa Platinum</h1>

        <tr>
            <td>Type of card:</td>
            <td><input type="text" name="typecard" /></td>
        </tr>

        <tr>
            <td>Cash:</td>
            <td><input type="text" name="cash" /></td>
        </tr>
    </table>
    <input type="submit" value="Submit" />
</form>
<a class="nav-link active" aria-current="page" href="/web/general"> To Main </a>
<%@include file="footer.jsp"%>


