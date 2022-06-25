function loadData() {
    var xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function (){
        if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
            var jsonResponse = JSON.parse(xmlHttpRequest.responseText);
            var contentHtml = '';
            for (let i = 0; i < jsonResponse.length; i++) {
                contentHtml += `<li>
                                    ${jsonResponse[i].name}                                 
                                </li>`;
            }
            document.getElementById('data').innerHTML = contentHtml;
        }
    }
    xmlHttpRequest.open('GET', API_URL);
    xmlHttpRequest.send();
}

document.addEventListener('DOMContentLoaded', function (){
    loadData();
})