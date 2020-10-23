<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/>

<h1>Transactions:</h1>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Recipient</th>
        <th scope="col">Sender</th>
        <th scope="col">Value</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${transactions}" var="transaction">
        <tr>
            <th scope="row">${transaction.id}</th>
            <td>${transaction.recipient}</td>
            <td>${transaction.sender}</td>
            <td>${transaction.value}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>



<jsp:include page="footer.jsp"/>