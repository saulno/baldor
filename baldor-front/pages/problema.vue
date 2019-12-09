<template>
    <div>
        <ul>
            <li>
                <nuxt-link to='perfil'>Mi pefil</nuxt-link>
            </li>
            <li>
                <nuxt-link to='contenido'>Aprende más</nuxt-link>
            </li>
            <li>
                <nuxt-link to='problema'>Pon a prueba tu conocimiento</nuxt-link>
            </li>
        </ul>
        <div class="instruccion">
            {{ inst }}
        </div>
        <div id="latex"></div>
        <form >
            <div><input class="login-text" v-model="respuesta" type="text" name="username" id="username" placeholder="Respuesta"></div>
            <div><input class="login-btn" type="submit" value="Evaluar" @click.stop.prevent="submit()"></div>
        </form>
    </div>
</template>

<script>
import axios from "axios";

export default {
    computed: {
        name() {
            return this.$store.state.name
        }
    },
    data() {
        return {
            inst: "",
            expr: "",
            resp: "",
            respuesta: ""
        }
    },
    async created() {
        try {
            const res = await axios.get('drools/api/usuarios/ejercicio', {
                username: name,
            })
            console.log(res)
            this.inst = res['data'][0]['instruccion']
            this.expr = res['data'][0]['ecuacion']
            this.resp = res['data'][0]['respuesta']

        } catch (error) {
            console.log(error)
        }
        var latex = algebra.toTex(this.expr);
        var latexDiv = document.getElementById("latex");
        katex.render(latex, latexDiv);
    },
    methods: {
        submit() {
            let miresp = this.removeSpaces(this.respuesta);
            let correcta = this.removeSpaces(this.resp)
            console.log(miresp, correcta)
        },
        removeSpaces(str) {
            return str.replace(/\s/g, '');
        }
    }
}
</script>

<style scoped>
    ul {
        display: flex;
        width: 100%;
        background-color: rgb(140, 228, 181);
        color: white;
        font-family: 'Inconsolata', monospace;
        font-size: 1.2rem;
    }

    li {
        width: 33%;
        text-align: center;
    }

    .instruccion {
        text-align: center;
        font-size: 3rem;
        margin-top: 2vh;
    }

    #latex {
        margin: 0 auto;
        text-align: center;
        font-size: 1.2rem;
    }

    form {
        text-align: center;
        margin: 0 auto;
        margin-top: 10vh;
    }

    .login-text {
        border-bottom: 1px solid rgb(140, 228, 181);
        margin-bottom: 20px;
    }

    .login-btn {
        background-color: rgb(140, 228, 181);
        border-radius: 40px;
        width: 30%;
        margin: 0 auto;
    }
</style>
