<template>
    <div class="row form-margin">
        <div class="col d-flex justify-content-center font-weight-bold align-items-center">
            <div class="card">
                <div class="card-body bg-light form-group">
                    <div class="row">
                        <div class="col align-self-center">
                            ProfitTrailer Manager
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-10">
                            <input class="form-control" name="password" type="password" v-model="input.password" placeholder="Password">
                        </div>
                        <div class="col-1 pt-2">
                            <a href="#" @click.prevent="login()">
                                <font-awesome-icon :icon="['fas','sign-in-alt']" class="text-dark big"></font-awesome-icon>
                            </a>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col">
                            <span v-if="error" class="text-soft-danger">{{error}}</span>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                error: "",
                input: {
                    password: ""
                }
            }
        },
        methods: {
            login() {
                if(this.input.password !== "") {
                    axios.post('/api/v1/login?password=' + this.input.password).then(() => {
                        window.location.href = '/';
                    }).catch((error) => {
                        if (!error.response) {
                            window.location.href = '/';
                        } else {
                            this.error = error.response.data.message;
                        }
                    })
                } else {
                    this.error = "Provide a password"
                }
            }
        }
    }
</script>

<style scoped>
    .form-margin {
        margin-top: 20%;
    }

    .text-soft-danger {
        color: #be584a;
    }

    .big {
        font-size: 20px;
    }
</style>