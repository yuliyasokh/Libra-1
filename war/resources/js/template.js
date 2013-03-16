/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function toggleedit(selector)
{
    $(selector).toggle();
    return false;
}
/*
function submitDelete(dAction,dSelector)
{
    var form = document.createElement("form");
    form.setAttribute("method", "POST");
    form.setAttribute("action", "delTemplate.html");
    for (var i in $(':checkbox[name^=template]'))
        form.appendChild(i);
    form.submit();
    return false;
}*/

function submitDelete(dAction,dSelector)
{
    var form = document.createElement("form");
    form.setAttribute("method", "POST");
    form.setAttribute("action", dAction);
    for (var i in $(dSelector))
        form.appendChild(i);
    form.submit();
    return false;
}