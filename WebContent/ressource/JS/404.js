
$( document ).ready(function() {
    let path = 'ressource/img/404/',
        files = ['coyotte.gif', 'lincoln.gif', 'mickey.gif', 'rick.gif'],
        i = Math.floor(Math.random() * files.length);
    let url = (path + files[i]);
    $("#404gif").attr('src', url);
});