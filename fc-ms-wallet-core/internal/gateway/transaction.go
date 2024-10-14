package gateway

import "github.com/jhonatapers/fc-ms-wallet-core/internal/entity"

type TransactionGateway interface {
	Create(transaction *entity.Transaction) error
}
