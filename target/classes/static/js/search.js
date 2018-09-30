$(document).ready(function() {

    $("#clear").click(function () {
       location.reload();
    });
    var langCode = ""; //$("#languageSelect").val();
    var langText = "";
    var progLangText = ""; //$("#progLangSelect").val();
    var progLangVal = "";
    var searchObject = {};
    var counter = 0;
   // piObject.langCode = langCode;
    //piObject.progLangId = progLangId;

    $("#languageSelect").change(function(){
        if($("#languageSelect").val()!= ""){
            langCode += $("#languageSelect").val() + ",";

            langText += $("#languageSelect option:selected").text() + ", ";
            var labelLang = "<label>" + langText + "</label>"
            $("#searchPeramLang").html(labelLang);
            //$('#languageSelect').attr("disabled", true);
        }


    });


    $("#progLangSelect").change(function(){

            if($("#progLangSelect").val()!= ""){
                progLangVal += $("#progLangSelect").val() + ",";

                progLangText += $("#progLangSelect option:selected").text() + ", ";
                var labelProg = "<label>" + progLangText + "</label>"
                $("#searchPeramProg").html(labelProg);
                counter++;
            }





    });


    $("#findDevelopers").click(function () {
        if (langCode =="" && progLangVal==""){
            alert("Select at least one criteria")
        }
        else{
            searchObject.langCode = langCode;
            searchObject.progLangId = progLangVal;
            $.ajax({
                contentType: 'application/json',
                url: "displayDevelopers",
                type: 'POST',
                dataType: "json",
                data: JSON.stringify(searchObject),
                success: function(res) {
                    if (res.tableMarkup == ""){
                        alert("Search criteria is limited to max TWO programming languages and ONE languages");
                            location.reload();

                    }
                    else{
                        $("#tableDiv").html(res.tableMarkup);
                        $("#searchPeramLang").html("");
                        $("#searchPeramProg").html("");
                        langCode = "";
                        progLangVal = "";
                        progLangText = "";
                        langText ="";
                    }



                },
                error: function(xhr, status, error) {
                    alert("somethign went wrong!")

                }
            });
        }







    });

});
