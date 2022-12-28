<jsp:include page="/view/header.jsp" />

<h1>Main</h1>

<form action="subject">
    <button type="submit">Novo Tópico</button>
</form>
<br />

<input type="date" id="day_scheduling" name="day_scheduling"/>
<br />

<button id="new-scheduling-btn">novo horário</button>

<table border="1">
    <caption>Agenda do dia <div id="day"></div></caption>

    <thead id="thead-scheduling">
        <tr>
            <th>Tópico</th>
            <th>Inicio</th>
            <th>Fim</th>
        </tr>
    </thead>

    <tbody id="table-scheduling-list">
            
    </tbody>

    <tbody>

        <tr id="table-scheduling-empty">
            <td>Agenda Vazia</td>
        </tr>
    </tbody>
</table>

<p id="session-date" style="display: none;"><% out.print(request.getSession().getAttribute("day")); %></p>


<jsp:include page="/view/modal.jsp" />
<jsp:include page="/view/footer.jsp" />