
$( document ).ready(function() {
    let path = 'ressource/img/500/',
        files = ['bob.gif', 'smoke.gif', 'debranche.gif', 'dark.gif'],
        i = Math.floor(Math.random() * files.length);
    let url = (path + files[i]);
    $("#500gif").attr('src', url);
});