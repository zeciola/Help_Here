$(document).ready(function() {
    $('#contact_form').bootstrapValidator({
            // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nome: {
                    validators: {
                        stringLength: {
                            min: 2,
                        },
                        notEmpty: {
                            message: 'Opps, insira o seu nome :)'
                        }
                    }
                },
                /*last_name: {
                    validators: {
                        stringLength: {
                            min: 2,
                        },
                        notEmpty: {
                            message: 'Please supply your last name'
                        }
                    }
                },*/
                email: {
                    validators: {
                        notEmpty: {
                            message: 'Opps, insira o seu email :)'
                        },
                        emailAddress: {
                            message: 'Opps, insira um e-mail valido :)'
                        }
                    }
                },
                celular: {
                    validators: {
                        notEmpty: {
                            message: 'Opps, insira o seu celular :)'
                        },
                        phone: {
                            country: 'BR',
                            message: 'Opps, insira um número valido de celular :)'
                        }
                    }
                },
                endereco: {
                    validators: {
                        stringLength: {
                            min: 8,
                        },
                        notEmpty: {
                            message: 'Opps, insira o seu endereço :)'
                        }
                    }
                },
                cidade: {
                    validators: {
                        stringLength: {
                            min: 4,
                        },
                        notEmpty: {
                            message: 'Opps, insira a sua cidade :)'
                        }
                    }
                },
                estado: {
                    validators: {
                        notEmpty: {
                            message: 'Opps, insira o seu estado :)'
                        }
                    }
                },
                cep: {
                    validators: {
                        notEmpty: {
                            message: 'Opps, insira o seu CEP :)'
                        },
                        /*zipCode: {
                            country: 'US',
                            message: 'Please supply a vaild zip code'
                        }*/
                    }
                },
                /*comment: {
                    validators: {
                        stringLength: {
                            min: 10,
                            max: 200,
                            message: 'Please enter at least 10 characters and no more than 200'
                        },
                        notEmpty: {
                            message: 'Please supply a description of your project'
                        }
                    }
                }*/
            }
        })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
            $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});