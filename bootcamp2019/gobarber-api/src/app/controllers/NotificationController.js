import User from '../models/User';
import Notification from '../schemas/Notification';

class NotificationController {
    async index(req, res) {
        const checkIsProvider = await User.findOne({
            where: {
                id: req.userId,
                provider: true,
            },
        });

        if (!checkIsProvider) {
            return req
                .status(401)
                .json({ error: 'Only provider can load notifications' });
        }

        const notifications = await Notification.find({
            user: req.userId,
        })
            .sort({ createdAt: 'desc' })
            .limit(20);

        return res.json(notifications);
    }

    async update(req, res) {
        const notifications = await Notification.findByIdAndUpdate(
            req.params.id,
            {
                read: true,
            },
            {
                new: true,
            }
        );
        return res.json(notifications);
    }
}

export default new NotificationController();
