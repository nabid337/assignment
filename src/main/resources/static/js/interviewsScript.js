$(document).ready(function() {


   // $('#interviewTable').DataTable();

    $('#interviewTable').DataTable({
        "oLanguage": {
            "sEmptyTable": "  ",
            "infoEmpty": "  "
        }
    });


    $("#addButton").click(function () {
        var comment = $("#comment").val();
        var devId = $("#developerSelect").val();
        var score = $("#score").val();

        if(comment=="" || devId=="" || score==""){
            alert("Select all the field!");
        }
        else{
        var val = score.value;
        if (/^\d{1}$/.test(score) && score<="5") {
            // value is ok, use it
        } else {
            alert("Only digit(0-5) allowed!")
            $("#score").focus();
            return false
        }

        var interviewFrontEndInfo = {};
        interviewFrontEndInfo.devId = devId;
        interviewFrontEndInfo.score = score;
        interviewFrontEndInfo.comment = comment;


            $.ajax({
                contentType: 'application/json',
                url: "addInterview",
                type: 'POST',
                dataType: "json",
                data: JSON.stringify(interviewFrontEndInfo),
                success: function(res) {
                    var markup = "<tr id=" + res.interviewId + ">" +
                        "<td>" + res.interviewId + "</td>" +
                        "<td>" + res.score + "</td>" +
                        "<td>"+ res.comment + "</td>" +
                        "<td>" + res.devId + "</td>" +
                        "<td><input type=\"button\" class=\"btn btn-danger deleteClass\" value=\"Delete\" id=\"dev\" custId=" + res.interviewId + "></td>"+
                        "</tr>";
                    $("#interviewTable tbody").append(markup);
                   // alert("Successfully added");

                },
                error: function(xhr, status, error) {
                    alert("something went wrong!")

                }
            });
        }




    });


    $(document).on("click", ".deleteClass", function (e) {
        var id = $(this).attr("custId");
       /* row = $(this).closest('tr');
        var _data = $('#interviewTable').dataTable().fnGetData(row);
        var id = _data[0];*/
        var str = '#' + id;
        var deleteInfo = {};
        deleteInfo.id  = id;

        //$('#id').remove();
        $.ajax({
            contentType: 'application/json',
            url: "deleteInterview",
            type: 'POST',
            dataType: "json",
            data: JSON.stringify(deleteInfo),
            success: function(res) {
                alert("Successfully deleted");
            },
            error: function(xhr, status, error) {
                alert("something went wrong!")

            }
        });

        $(str).remove();
    });



});
