<template>
    <div>
        
        <p>&nbsp;</p>

        <p>
            <button class="btn btn-primary" type="submit" v-on:click="consultar">Consultar SAT</button>
        </p>

        <div class="card card-body bg-light">
            <strong>Resultado:</strong> 
            <span v-text="result"></span> <b-spinner label="Spinning" v-if="consultando"></b-spinner>
        </div>
        
    </div>
</template>

<script>
    import satService from '../services/sat';

    export default {
        name: "Main",
        data: () => {
            return {
                result: null,
                consultando: false
            }
        },
        methods: {
            consultar: function() {
                this.result = null;
                this.consultando = true;
                satService.consultar().then((result) => {
                    this.result = result.data.message;
                }).catch((err) => {
                    this.result = (err.response) ? err.response.data.message : err;
                }).finally(() => {
                    this.consultando = false;
                });
            }
        }
    };
</script>
