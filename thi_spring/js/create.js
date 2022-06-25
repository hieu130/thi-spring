document.addEventListener('DOMContentLoaded', function () {
    var productForm = document.forms['product-form'];
    var btnSubmit = productForm ['submit'];
    var textName = productForm['name'];
    var textPrice = productForm['wage'];
    if (btnSubmit !== null && btnSubmit !== undefined) {
        btnSubmit.onclick = function (event) {
            if(productForm.checkValidity()){ // gọi đến hàm validate của form
                event.preventDefault(); // ngăn việc form bị submit đi.
                // get data from form.
                var objData = {
                    name: textName.value,
                    price: textPrice.value,
                    thumbnail: textThumbnail.value,
                    description: textDescription.value,
                    status: textStatus.value,
                }
                postData(objData);
            }
        }
    }
})

function postData(objData) {
    var xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function () {
        if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
            var jsonResponse = JSON.parse(xmlHttpRequest.responseText);
            alert('Action success');
            window.location.href = '/vanilla-js-client/index.html';
        }
    }
    xmlHttpRequest.open('POST', API_URL);
    xmlHttpRequest.setRequestHeader('Content-Type', 'application/json'); // bắt buộc phải vị trí này
    xmlHttpRequest.send(JSON.stringify(objData));
}
