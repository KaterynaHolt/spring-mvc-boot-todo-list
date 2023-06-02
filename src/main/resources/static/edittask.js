function validateForm() {
    var text = document.forms["form"]["text"].value;
    var date = document.forms["form"]["date"].value;
    var status = document.forms["form"]["status"].value;
    var priority = document.forms["form"]["priority"].value;
    var tags = document.forms["form"]["tags"].value;
    const warnings = [];
    if (text == "" || text == "  "){
        warnings.push(" Text");
    }
    if (date == "") {
        warnings.push(" Date");
    }
    if (status == "") {
        warnings.push(" Status");
    }
    if (priority == ""){
        warnings.push(" Priority");
    }
    if (tags == ""){
        warnings.push(" Tags");
    }
    if (warnings.length != 0){
        alert("You haven't filled" + warnings.toString() + " fields!");
        return false;
    }
    else{
        return true;
    }
}