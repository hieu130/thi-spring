var API_URL = 'https://thi-spring.herokuapp.com/api/v1/employees';

function getParameterFromUrl(name){
    var url_string = window.location.href;
    var url = new URL(url_string);
    return url.searchParams.get(name);
}