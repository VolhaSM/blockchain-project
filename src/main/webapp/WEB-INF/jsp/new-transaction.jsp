<jsp:include page="header.jsp"/>


<h1> New Transaction: </h1>

<form action="/blockchain-project/${walletId}/new-transaction.html" method="post">

    <div class="form-group">
        <label for="formGroupExampleInput2">Recipient</label>
        <input type="text" class="form-control" name="recipient" id="formGroupExampleInput2" placeholder="Recipient">
    </div>
    <div class="form-group">
        <label for="formGroupExampleInput2">Private Key</label>
        <input type="text" class="form-control" name="privateKey" id="formGroupExampleInput3" placeholder="Private Key">
    </div>
    <div class="form-group">
        <label for="formGroupExampleInput2">Value</label>
        <input type="text" class="form-control" name="value" id="formGroupExampleInput4" placeholder="value">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>



<jsp:include page="footer.jsp"/>