<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<body>
<form role="general" method="post" action="/web/general" >

    <header>
        <h1>Y-BANK</h1>
        <p>DESKTOP</p>
        <nav>
            <ul>
                <h2>Products</h2>
                <li><a href="/web/card">Cards</a></li>
                <li><a href="/web/credits">Credits</a></li>
                <li><a href="/web/deposits">Deposits</a></li>
                <h2> </h2>
                <li><a href="/web/my_products">My products</a></li>
                <h2> </h2>
                <li><a href="/web/payments">Payments</a></li>
                <h2> </h2>
                <li><a href="/web/cardtransfer">Card Transfer</a></li>
            </ul>
        </nav>
        <p>INFORMATION</p>
        <nav>
            <ul>
                <li><a href="index.html">Special offers</a></li>
                <li><a href="catalog.html">Electronic documents</a></li>
                <li><a href="index.html">Exchange Rates</a></li>
                <li><a href="index.html">ATMs and branches</a></li>
            </ul>
        </nav>
    </header>
<%@include file="footer.jsp"%>