$.ajax({
    url: '/api/doctor/all',
    type: 'GET',
    success: function (data) {
        parseListDoctorJson(data);
    }
});

$('#btn-search-doct').click(function () {
    $('#search-doct').submit(getContent());
});


function parseListDoctorJson(doctors) {
    $.each(doctors, function (i, item) {
        var divDoctor = '<div class="columns large-4 medium-6 div-doctor">' +
            '<div class="doctor">' +
            '<h5 class="doctor-name">' + item.name + '</h5>' +
            '<div class="doctor-box">' +
            '<div class="doctor-image">' +
            '<a href="/doctor/id/' + item.doctorCode + '">' +
            '<img src="' + item.imageProfile + '" alt=""/>' +
            '</a></div>' +
            '<div class="doctor-body">' +
            '<h6 style="font-weight: bold">' + item.roles + '</h6>' +
            '<p>' + item.about.substring(0, 250) + '...</p>' +
            '<a href="/doctor/id/' + item.doctorCode + '"class="link-more">' +
            '<i class="fa fa-plus"></i>CHI TIẾT' +
            '</a> </div> </div> </div> </div>';
        $('#doct-list').append(divDoctor);
    })
}

function getContent() {
    var name = $('#input-name').val();
    var nationality = $('#select-nationality').val();
    var specialities = $('#select-spec').val();
    var gender = $('#select-gender').val();
    var education = $('#select-edu').val();
    var hospital = $('#select-hospital').val();

    var search_condition = {
        name: name,
        nationality: nationality,
        specialities: specialities,
        gender: gender,
        education: education,
        hospital: hospital
    };
    console.log('searchDTO: ' + JSON.stringify(search_condition));

    var url = "/api/doctor/search";

    $('#doct-list').empty();
    $.ajax({
        url: url,
        type: 'POST',
        data: JSON.stringify(search_condition),
        contentType: 'application/json',
        success: function (data) {
            parseListDoctorJson(data);
        }
    });
}
