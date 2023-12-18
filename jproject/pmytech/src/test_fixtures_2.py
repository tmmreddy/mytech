import pytest


@pytest.fixtures
def user_data():
    user = {
        "username": "muni",
        "email": "munit@example.com",
        "password": "secretpassword"
    }
    return user


@pytest.fixture
def product_data():
    product = {
        "product_name": "Sample Product",
        "price": 29.99,
        "quantity": 100
    }
    return product


def test_user_registration(user_data):
    assert user_data["username"] == "muni"
    assert user_data["email"] == "munit@example.com"
    assert user_data["password"] == "secretpassword"
    print("User registration test passed!")


def test_product_price(product_data):
    assert product_data["price"] == 29.99
    print("Product price test passed!")


def test_combined_data(user_data, product_data):
    assert user_data["username"] == "muni"
    assert product_data["product_name"] == "Sample Product"
    print("Combined data test passed!")
