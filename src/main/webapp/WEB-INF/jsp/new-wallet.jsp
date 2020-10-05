<jsp:include page="header.jsp"/>


<h1> New Wallet: </h1>

<form action="/blockchain-project/new-wallet.html" method="post">
    <div class="form-group">
        <label for="formGroupExampleInput2">User id</label>
        <input type="text" class="form-control" name="userId" id="formGroupExampleInput1" placeholder="User user id">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Public Key</label>
        <input type="email" class="form-control" name="publicKey" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter public key">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
        <label for="formGroupExampleInput2">Private Key</label>
        <input type="text" class="form-control" name="privateKey" id="formGroupExampleInput2" placeholder="Enter Private Key">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>



<jsp:include page="footer.jsp"/>