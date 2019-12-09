<template>
    <div>
        <div class="login-container">
            <h2>Login</h2>
            <form @submit.prevent="onSubmit">
                <div>
                    <label for="username">Username</label>
                    <input class="login-text" type="text" :input="username" @input="updateName" name="username" id="username" placeholder="Username">
                </div>
                <nuxt-link to="home">
                    <input type="submit" value="Login">
                </nuxt-link>
            </form>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import { mapState } from 'vuex';

export default {
    head() {
        return {
            title: "Login", 
        };
    },
    computed: {
        ...mapState({
            username: state => state.name
        })
    },
    methods: {
        updateName (e) {
            console.log(e.target.value)
            this.$store.commit('updateName', e.target.value)
        }
    },
    async created() {
        try {
            const res = await axios.get("drools/api/problema/actualizar")
            console.log(res);
        } catch (error) {
            console.log(error);
        }
    },
}
</script>

<style scoped>
    .login-container {
        font-family: 'Inconsolata', monospace;
        margin: 0 auto;
        text-align: center;
        margin-top: 20vh;
        border: 1px solid green;
        border-radius: 30px;
        width: 40vw;
        padding: 20px;
    }

    h2 {
        font-size: 2.5rem;
        font-weight: 1000;
    }

    form {
        font-size: 1.5rem;
        font-weight: 10;
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