<script>

function getScheduling() {
    $.ajax({
        url: 'day_scheduling',
        type: 'GET',
        data: {
            day_scheduling: $("#day_scheduling").val()
        },
        success: function(response) {
            updateTable(response);
        }
    });
}

function saveScheduling() {

    $.ajax({
        url: 'scheduling',
        type: 'POST',
        data: {
            hour_start: $("#select-hour-start").val(),
            hour_end: $("#select-hour-end").val(),
            day_scheduling: $("#day_scheduling").val(),
            subject: $("#select-subject").val()
        },
        success: function(response) {
            updateTable(response);
        }
    });

}

function updateTable(data) {

    $("#day").text($("#day_scheduling").val());

    if (data.length == 0) {
        $("#thead-scheduling").css("display", "none");
        $("#table-scheduling-list").css("display", "none");
        $("#table-scheduling-empty").css("display", "table-row");
    } else {
        $("#thead-scheduling").css("display", "table-header-group");
        $("#table-scheduling-list").css("display", "table-row-group");
        $("#table-scheduling-empty").css("display", "none");

        html = "";

        for (let i = 0; i < data.length; i++) {
            html += "<tr><td>" + data[i].subject.name +
                    "</td><td>" + data[i].hourStart.split('T')[1] +
                    "</td><td>" + data[i].hourEnd.split('T')[1] + "</td></tr>";
        }

        $("#table-scheduling-list").html(html);
    }
}

function getSchedulingDate() {
    const date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    var currentDate = year + '-' + month + '-' + day;
    
    var sessionDate = $("#session-date").text();

    if (sessionDate == 'null') {
        $("#day_scheduling").val(currentDate);
    } else {
        $("#day_scheduling").val(sessionDate);
    }
}

$(document).ready(function() {

    getSchedulingDate();
    getScheduling();

    $("#day_scheduling").change(function(){ getScheduling(); });
    $("#new-scheduling-btn").click(function() {
        $("#modal-screen").css("display", "block");
        $("#modal").css("display", "block");
    });

    $("#add-scheduling").click(function() {
        $("#modal-screen").css("display", "none");
        $("#modal").css("display", "none");
    });

    $("#add-scheduling").click(function() { saveScheduling(); });
});

</script>