package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'Say Hello World!'
    request {
        method 'GET'
        url '/hello'
    }
    response {
        status 200
        body "Hello World!"
        headers {
            contentType(applicationJson())
        }
    }
}