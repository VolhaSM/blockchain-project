<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/>
<h1>Wallets:</h1>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Wallet Id</th>
        <th scope="col">Public Key</th>
        <th scope="col">Private Key</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${wallets}" var="wallet">
        <tr>
            <th scope="row">${wallet.id}</th>
            <td>${wallet.publicKey}</td>
            <td>${wallet.privateKey}</td>
            <td><p><a href="/blockchain-project/${wallet.id}/new-transaction.html" class="btn btn-primary btn-sm" role="button" aria-pressed="true">New Transaction</a></p><td>

            <td><p><a href="/blockchain-project/${wallet.id}/transaction-list" class="btn btn-primary btn-sm" role="button" aria-pressed="true">Transactions List</a></p><td>

            <td><p><a href="/blockchain-project/${wallet.id}/balance.html" class="btn btn-primary btn-sm" role="button" aria-pressed="true">Balance</a></p><td>

            <td><p><a href="/blockchain-project/${wallet.id}/blocks-list" class="btn btn-primary btn-sm" role="button" aria-pressed="true">Mined Blocks</a></p><td>

            <td><p><a href="http://localhost:8082/${wallet.id}/start-mining.html" class="btn btn-danger btn-sm" role="button" aria-pressed="true">Start Mining</a></p><td>
        </tr>
    </c:forEach>
    </tbody>

</table>


<jsp:include page="footer.jsp"/>