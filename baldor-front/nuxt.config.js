export default {
    mode: 'spa',
    /*
     ** Headers of the page
     */
    head: {
        title: process.env.npm_package_name || '',
        script: [
            { src: 'js/algebra-0.2.6.min.js', type: 'text/javascript' },
            { src: 'katex/katex.js', type: 'text/javascript' },
            // {
            //     src: "https://cdn.jsdelivr.net/npm/katex@0.11.1/dist/katex.min.js",
            //     integrity: "sha384-y23I5Q6l+B6vatafAwxRu/0oK/79VlbSz7Q9aiSZUvyWYIYsd+qj+o24G5ZU2zJz",
            //     crossorigin: "anonymous"
            // }
        ],
        meta: [
            { charset: 'utf-8' },
            { name: 'viewport', content: 'width=device-width, initial-scale=1' },
            { hid: 'description', name: 'description', content: process.env.npm_package_description || '' }
        ],
        link: [
            { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
            {
                rel: 'stylesheet',
                href: 'https://fonts.googleapis.com/css?family=Inconsolata|Tomorrow&display=swap'
            },
            {
                rel: 'stylesheet',
                href: 'katex/katex.css'
            }
            // {
            //     rel: "stylesheet",
            //     href: "https://cdn.jsdelivr.net/npm/katex@0.11.1/dist/katex.min.css",
            //     integrity: "sha384-zB1R0rpPzHqg7Kpt0Aljp8JPLqbXI3bhnPWROx27a9N0Ll6ZP/+DiW/UqRcLbRjq",
            //     crossorigin: "anonymous",
            // }
        ],
    },
    /*
     ** Customize the progress-bar color
     */
    loading: { color: '#fff' },
    /*
     ** Global CSS
     */
    css: [],
    /*
     ** Plugins to load before mounting the App
     */
    plugins: [],
    /*
     ** Nuxt.js dev-modules
     */
    buildModules: [
        // Doc: https://github.com/nuxt-community/nuxt-tailwindcss
        '@nuxtjs/tailwindcss',
    ],
    /*
     ** Nuxt.js modules
     */
    modules: [
        // Doc: https://axios.nuxtjs.org/usage
        '@nuxtjs/axios',
        '@nuxtjs/proxy'
    ],
    proxy: {
        '/drools': {
            target: 'http://localhost:8080',
            pathRewrite: {
                '^/drools': '/'
            }
        }
    },
    /*
     ** Axios module configuration
     ** See https://axios.nuxtjs.org/options
     */
    axios: {},
    /*
     ** Build configuration
     */
    build: {
        /*
         ** You can extend webpack config here
         */
        extend(config, ctx) {}
    }
}