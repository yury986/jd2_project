<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>
<body>
<form role="cardtransfer" method="post" action="/web/cardtransfer" >

    <table style="with: 50%">

        <tr>
            <td>Card Number Sender</td>
            <td><input type="text" name="cardsender" /></td>
        </tr>
        <tr>
            <td>Card Number Recipient</td>
            <td><input type="text" name="cardrecipient" /></td>
        </tr>
        <tr>
            <td>Sum</td>
            <td><input type="text" name="sumtransfer" /></td>
        </tr>
    </table>
    <input type="submit" value="Make a transfer" />
</form>
<a class="nav-link active" aria-current="page" href="/web/general"> To main</a>
<%@include file="footer.jsp"%>


