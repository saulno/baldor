<template>
    <div>
        <ul>
            
        </ul>
        Bienvenido {{ name }}
    </div>
</template>

<script>
export default {
    computed: {
        name () {
            return this.$store.state.name
        }
    },
}
</script>