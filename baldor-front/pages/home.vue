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
        <div class="welcome">
            Bienvenido <b>{{ name }}</b>, te extrañamos.
        </div>
    </div>
</template>

<script>
import axios from "axios";
import { mapState } from 'vuex';

export default {
    computed: {
        name () {
            return this.$store.state.name
        }
    },
    async created() {
        try {
            const res = await axios.post('drools/api/usuarios/registrar', {
                username: name,
            })
            console.log(res)
            this.$store.commit('updateProgreso', res['data']['progreso']);
        } catch (error) {
            console.log(error)
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

    .welcome {
        text-align: center;
        font-size: 3rem;
        margin-top: 30vh;
    }
</style>