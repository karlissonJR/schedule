<style>

    body {
        padding: 0;
        margin: 0;
    }

    table {
        width: 90%;
        margin: 5px auto;
        text-align: center;
    }

    footer {
        position: fixed;
        bottom: 22px;
        margin-right: auto;
        margin-left: auto;
        width: 100%;
        text-align: center;
    }

    form[action='topico'] {
        z-index: -1;
    }

    #table-scheduling-empty, #table-scheduling-list {
        display: none;
    }

    #table-scheduling-empty > td {
        margin: 50px;
        padding: 50px;
    }

    #modal-screen {
        position: absolute;
        top: 0;
        width: 100%;
        height: 100vh;
        background-color: black;
        opacity: 0.5;
        z-index: 3;
        display: none;
    }

    #modal {
        position: absolute;
        background-color: white;
        top: 28%;
        left: 35%;
        display: none;
        /* left: 10%;
        right: 10%;
        bottom: 10%; */

        width: 500px;
        height: 300px;
        /* margin: 10%; */
        z-index: 4;
    }

</style>