package gateway

import (
	"github.com/jhonatapers/fc-ms-wallet-core/internal/entity"
)

type ClientGateway interface {
	Get(id string) (*entity.Client, error)
	Save(client *entity.Client) error
}
