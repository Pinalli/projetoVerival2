	    </div>
	    
<!--    <div class="footer"> -->
	    <div style="display: block; margin: 30px;">
			<div class="text-center" style="width:100%">� Copyright AGES 2017 - Todos os direitos reservados</div>
	    </div>
	    
	    <script type="text/javascript" src="./js/jquery.min.js"></script>
	    <script type="text/javascript" src="./js/popper.min.js"></script>
	    <script type="text/javascript" src="./js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="./js/select2.min.js"></script>
	    <script type="text/javascript" src="./js/dataTables.min.js"></script>
		<script type="text/javascript" src="./js/dataTables.bootstrap4.min.js"></script>
		<script type="text/javascript" src="./js/moment.js"></script>
		<script type="text/javascript" src="./js/pt-br.js"></script>
		<script type="text/javascript" src="./js/transition.js"></script>
		<script type="text/javascript" src="./js/collapse.js"></script>
		<script type="text/javascript" src="./js/bootstrap-datetimepicker.min.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#lista-ftp').DataTable({
					"columnDefs": [{ "orderable": false, "targets": [2, 3, 4] }]
				});
			} );
		</script>
	</body>
</html>