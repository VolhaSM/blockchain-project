<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/>
<h1>Wallets:</h1>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Wallet ID</th>
        <th scope="col">Public Key</th>
        <th scope="col">Private Key</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${wallets}" var="wallet">
        <tr>
            <th scope="row">${wallet.id}</th>
            <td>${wallet.userId}</td>
            <td>${wallet.publicKey}</td>
            <td>${wallet.privateKey}</td>
            <td><p><a href="/blockchain-project/${wallet.id}/wallets.html" class="text-primary">Edit</a></p><td>
        </tr>
    </c:forEach>
    </tbody>

</table>


<jsp:include page="footer.jsp"/>