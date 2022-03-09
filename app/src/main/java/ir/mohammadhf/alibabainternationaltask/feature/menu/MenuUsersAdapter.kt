package ir.mohammadhf.alibabainternationaltask.feature.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import ir.mohammadhf.alibabainternationaltask.ImageLoader
import ir.mohammadhf.alibabainternationaltask.core.BaseListAdapter
import ir.mohammadhf.alibabainternationaltask.core.BaseViewHolder
import ir.mohammadhf.alibabainternationaltask.data.model.User
import ir.mohammadhf.alibabainternationaltask.databinding.ItemUserBinding
import javax.inject.Inject

class MenuUsersAdapter @Inject constructor() :
    BaseListAdapter<User, MenuUsersAdapter.MenuUserViewHolder>() {

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuUserViewHolder =
        MenuUserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    inner class MenuUserViewHolder(
        private val itemUserBinding: ItemUserBinding
    ) : BaseViewHolder<User>(itemUserBinding.root) {
        override fun bind(item: User) {
            imageLoader.load(
                itemUserBinding.root.context, item.avatar, itemUserBinding.avatarIv
            )
            itemUserBinding.apply {
                username.text = item.firstName + " " + item.lastName
                email.text = item.email
            }
        }
    }
}