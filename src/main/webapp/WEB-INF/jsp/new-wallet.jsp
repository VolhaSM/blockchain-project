<jsp:include page="header.jsp"/>


<h1> New Wallet: </h1>

<form action="/blockchain-project/new-wallet.html" method="post">
<%--    <div class="form-group">--%>
<%--        <label for="formGroupExampleInput2">User id</label>--%>
<%--        <input type="text" class="form-control" name="userId" id="formGroupExampleInput1" placeholder="User id">--%>
<%--    </div>--%>
    <div class="form-group">
        <label for="formGroupExampleInput2">Public Key</label>
        <input type="text" class="form-control" name="publicKey" id="formGroupExampleInput2" placeholder="Enter Public Key">
    </div>
    <div class="form-group">
        <label for="formGroupExampleInput2">Private Key</label>
        <input type="text" class="form-control" name="privateKey" id="formGroupExampleInput3" placeholder="Enter Private Key">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>



<jsp:include page="footer.jsp"/>