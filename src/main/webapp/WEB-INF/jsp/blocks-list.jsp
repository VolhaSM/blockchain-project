<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/>

<h1>Mined Blocks:</h1>

<table class="table">
    <thead>
    <tr>

        <th scope="col">Block Id</th>
        <th scope="col">Hash</th>
        <th scope="col">Previous Hash</th>
        <th scope="col">Data</th>
        <th scope="col">Timestamp</th>
        <th scope="col">Nonce</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${blocks}" var="block">
        <tr>
            <td>${block.id}</td>
            <td>${block.hash}</td>
            <td>${block.previousHash}</td>
            <td>${block.data}</td>
            <td>${block.timestamp}</td>
            <td>${block.nonce}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>